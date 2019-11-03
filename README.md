# ProgressButton  [![](https://jitpack.io/v/muramrr/ProgressButton.svg)](https://jitpack.io/#muramrr/ProgressButton) [![](https://img.shields.io/github/license/muramrr/ProgressButton.svg)](https://github.com/muramrr/ProgressButton/blob/master/LICENSE)

Original prototype [Dribble link](https://dribbble.com/shots/1945593-Login-Home-Screen)

[iOS library](https://github.com/entotsu/TKSubmitTransition)

Sample project available in **app** directory


## Overview

Custom button with progress anim and transition to another activity/fragment

Better to use with **AsyncTask** or **Handler()** or *RxJava* **doFinally()**

![](https://github.com/muramrr/ProgressButton/blob/master/test.gif)
## Installation

Add jitpack repo in your project.gradle
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
 }
 ```

Add implementation in your app.gradle
```gradle
dependencies {
  implementation 'com.github.muramrr:ProgressButton:1.0'
}
```
## Usage XML

```xml
<com.mmdev.progressbuttonlib.ProgressButton
    android:layout_height="50dp"
    android:layout_width="match_parent"
    android:id="@+id/btn_done"
    android:layout_margin="20dp"
    app:backgroundColor="#2962FF"
    app:progressColor="@android:color/holo_orange_light"
    app:text="DONE!"
    app:textColor="@android:color/black" />

```
Available attributes:
* app:backgroundColor - **Button background color** *(default = Color.BLUE)*
* app:progressColor - **Progress loading color** *(default = Color.WHITE)*
* app:text - **Button text** *(default = "")*
* app:textColor - **Button text color** *(default = Color.WHITE)*
## Code

#### Java
```java
private ProgressButton pb_button;
...
pb_button = findViewById(R.id.btn_done);
pb_button.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick (View v) {
    pb_button.startAnim(); //start progress button loading
    /**
    * manual stop animation method
    * you can handle it with Runnable()
    * delay progress loading in Handler()
    * or you can use it with AsyncTask class
    * startAnim() in preExecute
    * stopAnim() in postExecute
    */
    new Handler().postDelayed(() -> pb_button.stopAnim(this::startSecondActivity), 760);
  }
});
```
#### Kotlin
```kotlin
val progressButton = findViewById<ProgressButton>(R.id.btn_done)
progressButton.setOnClickListener {
	progressButton.startAnim()
	Handler().postDelayed({ progressButton.stopAnim { startMainActivity() }}, 2000)
}
```

#### RxJava 2 + kotlin
```rx
disposables.add(signUp()
            .observeOn(AndroidSchedulers.mainThread())
	    .doOnSubscribe { progressButton.startAnim() }
	    .doOnSuccess { progressButton.stopAnim { startMainActivity() } }
            .subscribe({
	    		//your code
                       },
                       {
                       Toast.makeText(this,"error",
                                      Toast.LENGTH_SHORT).show()
                       }))
```


#### Public methods:
* setBgColor(int color) - **Set button background color**
* setProColor(int color) - **Set progress color**
* setButtonText(String str) - **Set button text**
* setTextColor(int color) - **Set button text color**

## License
```license
MIT License

Copyright (c) 2019 Andrii Kovalchuk

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
