//package com.example.jdncprojcet8.cors;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//
//public class CorsFilter {
//    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    CorsConfiguration config = new CorsConfiguration();
//    config.setAllowCredentials(true);
//    config.addAllowedOrigin("*");
//    config.addAllowedHeader("*");
//    config.addAllowedMethod("OPTIONS");
//    config.addAllowedMethod("GET");
//    config.addAllowedMethod("POST");
//    source.registerCorsConfiguration("/**", config);
//    return new CorsFilter(source);
//
//}
