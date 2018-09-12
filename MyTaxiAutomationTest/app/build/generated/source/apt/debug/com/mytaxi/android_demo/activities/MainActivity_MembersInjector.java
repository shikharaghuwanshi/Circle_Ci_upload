// Generated by Dagger (https://google.github.io/dagger).
package com.mytaxi.android_demo.activities;

import com.mytaxi.android_demo.utils.PermissionHelper;
import com.mytaxi.android_demo.utils.network.HttpClient;
import com.mytaxi.android_demo.utils.storage.SharedPrefStorage;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<SharedPrefStorage> mSharedPrefStorageProvider;

  private final Provider<HttpClient> mHttpClientProvider;

  private final Provider<PermissionHelper> mPermissionHelperProvider;

  public MainActivity_MembersInjector(
      Provider<SharedPrefStorage> mSharedPrefStorageProvider,
      Provider<HttpClient> mHttpClientProvider,
      Provider<PermissionHelper> mPermissionHelperProvider) {
    this.mSharedPrefStorageProvider = mSharedPrefStorageProvider;
    this.mHttpClientProvider = mHttpClientProvider;
    this.mPermissionHelperProvider = mPermissionHelperProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<SharedPrefStorage> mSharedPrefStorageProvider,
      Provider<HttpClient> mHttpClientProvider,
      Provider<PermissionHelper> mPermissionHelperProvider) {
    return new MainActivity_MembersInjector(
        mSharedPrefStorageProvider, mHttpClientProvider, mPermissionHelperProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    AuthenticatedActivity_MembersInjector.injectMSharedPrefStorage(
        instance, mSharedPrefStorageProvider.get());
    injectMHttpClient(instance, mHttpClientProvider.get());
    injectMPermissionHelper(instance, mPermissionHelperProvider.get());
    injectMSharedPrefStorage(instance, mSharedPrefStorageProvider.get());
  }

  public static void injectMHttpClient(MainActivity instance, HttpClient mHttpClient) {
    instance.mHttpClient = mHttpClient;
  }

  public static void injectMPermissionHelper(
      MainActivity instance, PermissionHelper mPermissionHelper) {
    instance.mPermissionHelper = mPermissionHelper;
  }

  public static void injectMSharedPrefStorage(
      MainActivity instance, SharedPrefStorage mSharedPrefStorage) {
    instance.mSharedPrefStorage = mSharedPrefStorage;
  }
}