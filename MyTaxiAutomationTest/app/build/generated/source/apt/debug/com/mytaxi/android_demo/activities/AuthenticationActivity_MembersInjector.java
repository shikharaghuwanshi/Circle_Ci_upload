// Generated by Dagger (https://google.github.io/dagger).
package com.mytaxi.android_demo.activities;

import com.mytaxi.android_demo.utils.network.HttpClient;
import com.mytaxi.android_demo.utils.storage.SharedPrefStorage;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AuthenticationActivity_MembersInjector
    implements MembersInjector<AuthenticationActivity> {
  private final Provider<HttpClient> mHttpClientProvider;

  private final Provider<SharedPrefStorage> mSharedPrefStorageProvider;

  public AuthenticationActivity_MembersInjector(
      Provider<HttpClient> mHttpClientProvider,
      Provider<SharedPrefStorage> mSharedPrefStorageProvider) {
    this.mHttpClientProvider = mHttpClientProvider;
    this.mSharedPrefStorageProvider = mSharedPrefStorageProvider;
  }

  public static MembersInjector<AuthenticationActivity> create(
      Provider<HttpClient> mHttpClientProvider,
      Provider<SharedPrefStorage> mSharedPrefStorageProvider) {
    return new AuthenticationActivity_MembersInjector(
        mHttpClientProvider, mSharedPrefStorageProvider);
  }

  @Override
  public void injectMembers(AuthenticationActivity instance) {
    injectMHttpClient(instance, mHttpClientProvider.get());
    injectMSharedPrefStorage(instance, mSharedPrefStorageProvider.get());
  }

  public static void injectMHttpClient(AuthenticationActivity instance, HttpClient mHttpClient) {
    instance.mHttpClient = mHttpClient;
  }

  public static void injectMSharedPrefStorage(
      AuthenticationActivity instance, SharedPrefStorage mSharedPrefStorage) {
    instance.mSharedPrefStorage = mSharedPrefStorage;
  }
}