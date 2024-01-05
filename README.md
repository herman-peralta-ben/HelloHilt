# HelloHilt
Example App to use Dagger Hilt.

**Note: take a look on commits to see what changes on stages**

This example works with Hilt version `2.48`.

[Changes to use Hilt](https://github.com/herman-peralta-ben/HelloHilt/commit/47bba1edd14cfe07b36301c4f11fb5330d14c686).

### Project level build.gradle
```
plugins {
    ...
    //region Dagger - Hilt
    id("com.google.dagger.hilt.android") version "2.48" apply false
    //endregion Dagger - Hilt
    ...
}
```

### app level build.gradle
```
plugins {
    ...
    //region Dagger - Hilt
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    //endregion Dagger - Hilt
    ...
}
...
dependencies {
    ...
    //region Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    //endregion Dagger - Hilt
    ...
}
```
### Dagger Annotations
* `@HiltAndroidApp` on `Application` class.
* `@HiltViewModel` and `@Inject constructor` on `ViewModel` classes.
* `@Inject constructor` on injectable classes e.g. Repository.

**See di package for Modules**

### Use ViewModel on Composable
Use `hiltViewModel()`, works only if `MyViewModel` is annotated with `@HiltViewModel` and `@Inject constructor`.

```
@Composable
fun HelloHiltScreen(
   viewModel: MyViewModel = hiltViewModel()
) { ... }
```
