package com.don.dagger2sample.componentdependencysample;

import dagger.Component;

/**
 * <p>
 * Description：依赖了SonComponent，可以直接使用SonComponent中暴露出来的依赖，
 * 同时暴露出Father，供依赖FatherComponent的Component使用
 * </p>
 *
 * @author tangzhijie
 */
@Component(modules = FatherModule.class, dependencies = SonComponent.class)
public interface FatherComponent {

    Father getFather();
}
