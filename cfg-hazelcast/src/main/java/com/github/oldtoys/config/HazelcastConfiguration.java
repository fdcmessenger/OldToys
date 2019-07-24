/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.oldtoys.config;

import com.hazelcast.config.Config;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Administrator
 */
//@EnableHazelcastHttpSession
@EnableCaching
@Configuration
public class HazelcastConfiguration {

//    @Bean
//    public Config hazelcastConfig() {
//        return new Config().setInstanceName("hazelcast-instance")
//                .addMapConfig(
//                        new MapConfig()
//                                .setName("persons")
//                                .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
//                                .setEvictionPolicy(EvictionPolicy.LRU)
//                                .setTimeToLiveSeconds(20)
//                );
//    }
    @Bean
    public Config config() {

        Config config = new Config();
//
//        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
//
//        joinConfig.getMulticastConfig().setEnabled(false);
//        joinConfig.getTcpIpConfig().setEnabled(true).setMembers(singletonList("127.0.0.1"));

        return config;
    }
//    @Bean
//    public HazelcastInstance hazelcastInstance() {
////        MapAttributeConfig attributeConfig = new MapAttributeConfig()
////                .setName(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
////                .setExtractor(PrincipalNameExtractor.class.getName());
//
//        Config config = new Config();
//
//        config.getMapConfig(HazelcastSessionRepository.DEFAULT_SESSION_MAP_NAME)
////                .addMapAttributeConfig(attributeConfig)
////                .addMapIndexConfig(new MapIndexConfig(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE, false))
//                ;
//
//        return Hazelcast.newHazelcastInstance(config);
//    }
}
