package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.example.controllers.ManagementController;
import org.example.daos.ManagementDao;
import org.example.daos.TestDao;
import org.example.services.ManagementService;
import org.example.controllers.HRController;
import org.example.daos.HRDao;
import org.example.services.HRService;

public class TestApplication extends Application<TestConfiguration> {
    public static void main(final String[] args) throws Exception {
        new TestApplication().run(args);
    }
    @Override
    public String getName() {
        return "Test";
    }
    @Override
    public void initialize(final Bootstrap<TestConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final TestConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }
    @Override
    public void run(final TestConfiguration configuration,
                    final Environment environment) {
        environment.jersey()
                .register(new TestController(new TestService(new TestDao())));
        environment.jersey()
                .register(new ManagementController(
                        new ManagementService(
                                new ManagementDao())));
        environment.jersey()
                .register(new HRController(new HRService(new HRDao())));
    }

}
