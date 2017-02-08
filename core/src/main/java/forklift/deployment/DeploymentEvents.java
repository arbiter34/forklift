package forklift.deployment;

import java.util.List;
import java.util.Map;

public interface DeploymentEvents {
    Map<Class<?>, Map<Class<?>, List<Exception>>> onDeploy(Deployment deployment);
    void onUndeploy(Deployment deployment);

    /**
     * Process this deployment?
     * @param  deployment [description]
     * @return            [description]
     */
    default boolean filter(Deployment deployment) {
        return true;
    }
}
