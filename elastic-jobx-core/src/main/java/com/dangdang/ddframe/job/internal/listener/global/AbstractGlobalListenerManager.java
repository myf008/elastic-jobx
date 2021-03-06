/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.job.internal.listener.global;

import org.apache.curator.framework.recipes.cache.TreeCacheListener;

import com.dangdang.ddframe.job.internal.config.global.GlobalConfigurationService;
import com.dangdang.ddframe.job.internal.storage.global.GlobalNodeStorage;
import com.dangdang.ddframe.reg.base.CoordinatorRegistryCenter;

/**
 * 作业注册中心的全局配置监听器管理者的抽象类.
 * 
 * @author xiong.j
 */
public abstract class AbstractGlobalListenerManager{

    private GlobalNodeStorage globalNodeStorage;

    protected AbstractGlobalListenerManager(final CoordinatorRegistryCenter coordinatorRegistryCenter) {
    	GlobalConfigurationService globalConfigurationService = GlobalConfigurationService.getInstance(coordinatorRegistryCenter);
    	if (null != globalConfigurationService) {
    		globalNodeStorage = globalConfigurationService.getGlobalNodeStorage();
    	}
    }

    /**
     * 开启监听器.
     */
    public abstract void start();

    protected void addDataListener(final TreeCacheListener listener) {
        globalNodeStorage.addDataListener(listener);
    }
}
