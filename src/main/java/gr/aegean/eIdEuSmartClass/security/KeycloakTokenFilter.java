/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aegean.eIdEuSmartClass.security;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author nikos
 */
public abstract class KeycloakTokenFilter extends OncePerRequestFilter {

//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    private TokenAuthenticationUserDetailsService tokenAuthUserDetailsService;
//    private TokenService tokenService;
//
//    public KeycloakTokenFilter(TokenAuthenticationUserDetailsService userDetailsService, TokenService tokenService) {
//        this.tokenAuthUserDetailsService = userDetailsService;
//        this.tokenService = tokenService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain chain) throws ServletException, IOException {
//        KeycloakSecurityContext context = getKeycloakSecurityContext(request);
//        if (context != null) {
//            context.getIdToken().getGivenName();
//        }
//        chain.doFilter(request, response);
//    }
//
//    private KeycloakSecurityContext getKeycloakSecurityContext(HttpServletRequest request) {
//        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
//    }
}
