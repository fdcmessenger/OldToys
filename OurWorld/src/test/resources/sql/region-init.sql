-- 将NNSD的两个csv文件使用navicat导入到数据库，然后执行如下脚本
-- 将iso3166导入数据库，字段值需要特殊处理

-- 清空区域表
TRUNCATE geo_regions;
-- 重置主键为1
alter table geo_regions auto_increment=0;
-- global
Insert into geo_regions(name_en,m49_code,pid,pids,geo_type,remarks) 
SELECT u.`Global Name`,u.`Global Code`,0,'0,',1,u.`Global Name` from `unsd — methodology_en` u GROUP BY u.`Global Code`;

-- Region
Insert into geo_regions(name_en,m49_code,pid,pids,geo_type,remarks) 
SELECT u.`Region Name`,u.`Region Code`,
(SELECT id from geo_regions  WHERE m49_code=u.`Global Code`)
,'0,',2,u.`Region Name` from `unsd — methodology_en` u WHERE u.`Region Code` is not null GROUP BY u.`Region Code`;
-- sub region
Insert into geo_regions(name_en,m49_code,pid,pids,geo_type,remarks) 
SELECT u.`Sub-Region Name`,u.`Sub-Region Code`,
(SELECT id from geo_regions  WHERE m49_code=u.`Region Code`)
,'0,',3,u.`Sub-Region Name` from `unsd — methodology_en` u WHERE u.`Sub-Region Code` is not null GROUP BY u.`Sub-Region Code`;

-- intermedia region
Insert into geo_regions(name_en,m49_code,pid,pids,geo_type,remarks) 
SELECT u.`Intermediate Region Name`,u.`Intermediate Region Code`,
(SELECT id from geo_regions  WHERE m49_code=u.`Sub-Region Code`)
,'0,',4,u.`Intermediate Region Name` from `unsd — methodology_en` u WHERE u.`Intermediate Region Code` is not null GROUP BY u.`Intermediate Region Code`;

-- country or area  inter is not null
Insert into geo_regions(name_en,m49_code,iso_3_code,pid,pids,geo_type,remarks) 
SELECT u.`Country or Area`,u.`M49 Code`,u.`ISO-alpha3 Code`,
(SELECT id from geo_regions  WHERE m49_code=u.`Intermediate Region Code`)
,'0,',5,u.`Country or Area` from `unsd — methodology_en` u WHERE u.`Intermediate Region Code` is not null GROUP BY u.`M49 Code`;

-- country or area  sub is not null
Insert into geo_regions(name_en,m49_code,iso_3_code,pid,pids,geo_type,remarks) 
SELECT u.`Country or Area`,u.`M49 Code`,u.`ISO-alpha3 Code`,
(SELECT id from geo_regions  WHERE m49_code=u.`Sub-Region Code`)
,'0,',5,u.`Country or Area` from `unsd — methodology_en` u WHERE u.`Intermediate Region Code` is  null and u.`Sub-Region Code` is not null    GROUP BY u.`M49 Code`;

-- country or area  sub is not null inter is null
Insert into geo_regions(name_en,m49_code,iso_3_code,pid,pids,geo_type,remarks) 
SELECT u.`Country or Area`,u.`M49 Code`,u.`ISO-alpha3 Code`,
(SELECT id from geo_regions  WHERE m49_code=u.`Global Code`)
,'0,',5,u.`Country or Area` from `unsd — methodology_en` u WHERE u.`Intermediate Region Code` is  null and u.`Sub-Region Code` is null and u.`Region Code` is null  GROUP BY u.`M49 Code`;


-- 初始化pids
UPDATE geo_regions g JOIN (SELECT id,pids from geo_regions ) tmp on tmp.id = g.pid  set g.pids=concat(tmp.pids,tmp.id,',') WHERE g.geo_type=2;
UPDATE geo_regions g JOIN (SELECT id,pids from geo_regions ) tmp on tmp.id = g.pid  set g.pids=concat(tmp.pids,tmp.id,',') WHERE g.geo_type=3;
UPDATE geo_regions g JOIN (SELECT id,pids from geo_regions ) tmp on tmp.id = g.pid  set g.pids=concat(tmp.pids,tmp.id,',') WHERE g.geo_type=4;
UPDATE geo_regions g JOIN (SELECT id,pids from geo_regions ) tmp on tmp.id = g.pid  set g.pids=concat(tmp.pids,tmp.id,',') WHERE g.geo_type=5;

-- 初始化中文名称
UPDATE geo_regions g join (SELECT u.`Global Name` name,u.`Global Code` code from `unsd — methodology_cn` u GROUP BY u.`Global Code`) tmp on g.m49_code = tmp.code set g.name_cn=tmp.name WHERE g.geo_type=1 ;
UPDATE geo_regions g join (SELECT u.`Region Name` name,u.`Region Code` code from `unsd — methodology_cn` u GROUP BY u.`Region Code`) tmp on g.m49_code = tmp.code set g.name_cn=tmp.name WHERE g.geo_type=2 ;
UPDATE geo_regions g join (SELECT u.`Sub-Region Name` name,u.`Sub-Region Code` code from `unsd — methodology_cn` u GROUP BY u.`Sub-Region Code`) tmp on g.m49_code = tmp.code set g.name_cn=tmp.name WHERE g.geo_type=3 ;
UPDATE geo_regions g join (SELECT u.`Intermediate Region Name` name,u.`Intermediate Region Code` code from `unsd — methodology_cn` u GROUP BY u.`Intermediate Region Code`) tmp on g.m49_code = tmp.code set g.name_cn=tmp.name WHERE g.geo_type=4 ;
UPDATE geo_regions g join (SELECT  u.`Country or Area` name,u.`M49 Code` code from `unsd — methodology_cn` u GROUP BY u.`M49 Code`) tmp on g.m49_code = tmp.code set g.name_cn=tmp.name WHERE g.geo_type=5 ;
