package pl.coderslab.charity.email;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

//@AllArgsConstructor
@Configuration
public class CredentialsPresent implements Condition {

//    private final CredentialsProvider credentialsProvider;

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        return credentialsProvider.areCredentialsConfigured();
        return false;
    }
}
