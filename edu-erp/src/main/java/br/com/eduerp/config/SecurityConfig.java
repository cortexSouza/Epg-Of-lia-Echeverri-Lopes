package br.com.eduerp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Config inicial do MVP: endpoints liberados para você validar o CRUD rápido.
 *
 * PRÓXIMO PASSO (antes de ir pra produção): trocar permitAll() por autenticação
 * via JWT, com endpoints de login/registro e regras por papel (ADMIN, PROFESSOR, ALUNO).
 * Não esqueça disso — ERP sem autenticação real é risco de segurança grave.
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );
        return http.build();
    }
}
