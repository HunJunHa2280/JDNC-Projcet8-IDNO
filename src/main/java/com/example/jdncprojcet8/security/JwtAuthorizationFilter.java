//package com.example.jdncprojcet8.security;
//
//
//import com.example.jdncprojcet8.jwt.JwtUtill;
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//@Slf4j(topic = "JWT 검증 및 인가")
//public class JwtAuthorizationFilter extends OncePerRequestFilter {
//// JwtAuthorizationFilter : API에 전달되는 JWT 유효성 검증 및 인가 처리
//
//    private final JwtUtil jwtUtil;
//    private final UserDetailsServiceImpl userDetailsService;
//
//    public JwtAuthorizationFilter(JwtUtil jwtUtil, UserDetailsServiceImpl userDetailsService) {
//        this.jwtUtil = jwtUtil;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
//
//        String tokenValue = jwtUtil.getJwtFromHeader(req);
//
//        if (StringUtils.hasText(tokenValue)) {
//
//            if (!jwtUtil.validateToken(tokenValue)) {
//                log.error("Token Error");
//                return;
//            }
//
//            Claims info = jwtUtil.getUserInfoFromToken(tokenValue);
//
//            try {
//                setAuthentication(info.getSubject());
//            } catch (Exception e) {
//                log.error(e.getMessage());
//                return;
//            }
//        }
//
//        filterChain.doFilter(req, res);
//    }
//
//    // 인증 처리
//    public void setAuthentication(String username) {
//        SecurityContext context = SecurityContextHolder.createEmptyContext();
//        Authentication authentication = createAuthentication(username);
//        context.setAuthentication(authentication);
//
//        SecurityContextHolder.setContext(context);
//    }
//
//    // 인증 객체 생성
//    private Authentication createAuthentication(String username) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//    }
//}