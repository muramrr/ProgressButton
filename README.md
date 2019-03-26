# ProgressButton  [![](https://jitpack.io/v/muramrr/ProgressButton.svg)](https://jitpack.io/#muramrr/ProgressButton)

original source code: [**ProgressButton**](https://github.com/ldoublem/ProgressButton)

Some bugs and issues fixed. Code optimized to run more smoothly.

*modificated for public usage*

## Overview

Custom button with progress anim and transition to another activity/fragment

Better use with **AsyncTask** or **Handler()**

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
    app:backgroundColor="@android:color/holo_orange_light"
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
    pb_button.stopAnim(new ProgressButton.OnStopAnim() {
      @Override
      public void Stop() {
        Intent i=new Intent();
        i.setClass(MainActivity.this,SecondActivity.class);
        startActivity(i);
      }
    });
  }
});
```
Available methods:
* setBgColor(int color) - **Set button background color**
* setProColor(int color) - **Set progress color**
* setButtonText(String str) - **Set button text**
* setTextColor(int color) - **Set button text color**
