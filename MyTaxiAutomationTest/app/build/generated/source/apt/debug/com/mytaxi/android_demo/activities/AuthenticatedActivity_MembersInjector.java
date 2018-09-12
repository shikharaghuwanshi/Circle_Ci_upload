// Generated by Dagger (https://google.github.io/dagger).
package com.mytaxi.android_demo.activities;

import com.mytaxi.android_demo.utils.storage.SharedPrefStorage;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AuthenticatedActivity_MembersInjector
    implements MembersInjector<AuthenticatedActivity> {
  private final Provider<SharedPrefStorage> mSharedPrefStorageProvider;

  public AuthenticatedActivity_MembersInjector(
      Provider<SharedPrefStorage> mSharedPrefStorageProvider) {
    this.mSharedPrefStorageProvider = mSharedPrefStorageProvider;
  }

  public static MembersInjector<AuthenticatedActivity> create(
      Provider<SharedPrefStorage> mSharedPrefStorageProvider) {
    return new AuthenticatedActivity_MembersInjector(mSharedPrefStorageProvider);
  }

  @Override
  public void injectMembers(AuthenticatedActivity instance) {
    injectMSharedPrefStorage(instance, mSharedPrefStorageProvider.get());
  }

  public static void injectMSharedPrefStorage(
      AuthenticatedActivity instance, SharedPrefStorage mSharedPrefStorage) {
    instance.mSharedPrefStorage = mSharedPrefStorage;
  }
}
