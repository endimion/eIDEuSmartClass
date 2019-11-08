///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package gr.aegean.eIdEuSmartClass.security;
//
//import gr.aegean.eIdEuSmartClass.model.service.TokenService;
//import gr.aegean.eIdEuSmartClass.model.service.impl.TokenAuthenticationUserDetailsService;
//import gr.aegean.eIdEuSmartClass.utils.enums.RolesEnum;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
//import org.springframework.security.web.firewall.HttpFirewall;
//import org.springframework.security.web.firewall.StrictHttpFirewall;
//
///**
// *
// * @author nikos
// */
////@Configuration
////@EnableWebSecurity
////@Order(1)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private TokenAuthenticationUserDetailsService userDetailsService;
//    private TokenService tokenService;
//
//    @Autowired
//    public WebSecurityConfig(TokenAuthenticationUserDetailsService userDetailsService, TokenService tokenService) {
//        this.userDetailsService = userDetailsService;
//        this.tokenService = tokenService;
//    }
//
//    @Bean
//    public AuthenticationManager customAuthenticatiotnManager() throws Exception {
//        return authenticationManager();
//    }
//
//    @Bean
//    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
//        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        firewall.setAllowUrlEncodedSlash(true);
//        firewall.setAllowSemicolon(true);
//        return firewall;
//    }
//
//    @Override
//    public void configure(WebSecurity webSecurity) {
//        webSecurity.ignoring().antMatchers("/validateCode**").antMatchers("/tmp**");
//        webSecurity.ignoring().antMatchers("/updateclassRasp**").antMatchers("/tmp**");
//        webSecurity.ignoring().antMatchers("/landingTest**").antMatchers("/tmp**");
////         webSecurity.ignoring().antMatchers("/adminLogin**");
//        webSecurity.ignoring().antMatchers("/checkclassRasp**").antMatchers("/tmp**");
//        webSecurity.ignoring().antMatchers("/css**");
//        webSecurity.ignoring().antMatchers("/js**");
//        webSecurity.ignoring().antMatchers("/smart-class**");
//        webSecurity.ignoring().antMatchers("/selectTeam**");
//        webSecurity.ignoring().antMatchers("/selectConf**");
//        webSecurity.httpFirewall(allowUrlEncodedSlashHttpFirewall());
////        webSecurity.ignoring().antMatchers("/tmp**");
////
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/updateclass").access("hasAuthority('" + RolesEnum.ADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.SUPERADMIN.role() + "') or hasAuthority('" + RolesEnum.COORDINATOR.role() + "')")
//                //                .anyRequest().authenticated()
//                .antMatchers("/team").access("hasAuthority('"
//                + RolesEnum.ADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.SUPERADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.COORDINATOR.role() + "') or hasAuthority('"
//                + RolesEnum.VIRTUALPARTICIPANT.role() + "') or hasAuthority('"
//                + RolesEnum.VISITOR.role() + "')")
//                .antMatchers("/getUsersByRole**").access("hasAuthority('"
//                + RolesEnum.ADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.SUPERADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.COORDINATOR.role() + "') or hasAuthority('"
//                + RolesEnum.VIRTUALPARTICIPANT.role() + "') or hasAuthority('"
//                + RolesEnum.VISITOR.role() + "')")
//                .antMatchers("/updateUserRole**").access("hasAuthority('"
//                + RolesEnum.ADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.SUPERADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.COORDINATOR.role() + "') or hasAuthority('"
//                + RolesEnum.VIRTUALPARTICIPANT.role() + "') or hasAuthority('"
//                + RolesEnum.VISITOR.role() + "')")
//                .and().formLogin()
//                .loginPage("/landing").permitAll()
//                .and()
//                .addFilterBefore(authFilter(), RequestHeaderAuthenticationFilter.class)
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/error")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .deleteCookies("access_token")
//                .logoutSuccessUrl("/") //logoutSuccessUrl("/login?logout")
//                .and()
//                .csrf().disable();
//
//        http.authorizeRequests()
//                .antMatchers("/admin**").access("hasAuthority('"
//                + RolesEnum.ADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.SUPERADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.COORDINATOR.role() + "')")
//                //                .anyRequest().authenticated()
//                .antMatchers("/admin/edit**").access("hasAuthority('"
//                + RolesEnum.ADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.SUPERADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.COORDINATOR.role() + "')")
//                .antMatchers("/addSkypeRoom**").access("hasAuthority('"
//                + RolesEnum.ADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.SUPERADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.COORDINATOR.role() + "')")
//                .antMatchers("/deleteSkypeRoom**").access("hasAuthority('"
//                + RolesEnum.ADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.SUPERADMIN.role() + "') or hasAuthority('"
//                + RolesEnum.COORDINATOR.role() + "')")
//                .and().formLogin()
//                .loginPage("/adminLogin").permitAll()
//                .and()
//                .addFilterBefore(authFilter(), RequestHeaderAuthenticationFilter.class)
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/error")
//                .and()
//                .csrf().disable();
//
//    }
//
////    @Bean
////    public TokenAuthenticationFilter authFilter() {
////        return new TokenAuthenticationFilter(userDetailsService, tokenService);
////    }
//}
