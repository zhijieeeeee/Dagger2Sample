package com.don.dagger2sample.componentdependencysample;

import dagger.Component;

/**
 * <p>
 * Description：依赖了FatherComponent，可以使用依赖了FatherComponent中暴露的依赖，
 * 以及它的子Component暴露的依赖
 * </p>
 *
 * @author tangzhijie
 */
@Component(dependencies = FatherComponent.class)
public interface DependencyComponent {

    void inject(DependencyActivity dependencyActivity);
}
