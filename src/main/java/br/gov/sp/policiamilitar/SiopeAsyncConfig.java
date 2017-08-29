package br.gov.sp.policiamilitar;

@Configuration
@EnableAsync
public class SiopeAsyncConfig extends AsyncConfigurerSupport{

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Siope-");
        executor.initialize();
        return executor;
    }
}