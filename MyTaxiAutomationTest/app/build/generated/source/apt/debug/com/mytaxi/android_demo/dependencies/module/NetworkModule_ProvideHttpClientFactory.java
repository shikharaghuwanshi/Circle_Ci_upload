// Generated by Dagger (https://google.github.io/dagger).
package com.mytaxi.android_demo.dependencies.module;

import com.mytaxi.android_demo.utils.network.HttpClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class NetworkModule_ProvideHttpClientFactory implements Factory<HttpClient> {
  private final NetworkModule module;

  public NetworkModule_ProvideHttpClientFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public HttpClient get() {
    return Preconditions.checkNotNull(
        module.provideHttpClient(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static NetworkModule_ProvideHttpClientFactory create(NetworkModule module) {
    return new NetworkModule_ProvideHttpClientFactory(module);
  }

  public static HttpClient proxyProvideHttpClient(NetworkModule instance) {
    return Preconditions.checkNotNull(
        instance.provideHttpClient(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
