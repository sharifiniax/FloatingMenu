FoatingMenu
===============

This is a simple Menu that you can use it by constraintLayout in android studio. This library is based on answers (https://stackoverflow.com/questions/4139288/android-how-to-handle-right-to-left-swipe-gestures). 

Gradle
------
```
repositories {
       
        maven { url 'https://jitpack.io' }
    }
```

```
dependencies {

        implementation 'com.github.sharifiniax:FloatingMenu:0.1.0'
    }
```


Usage
-----
```xml
<com.sharifiniax.floatingmenu.FloatingMenu
        android:padding="20dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <Button
            android:id="@+id/btn1"
            android:text="Btn"
            app:layout_constraintTop_toTopOf="parent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
        <Button
            android:id="@+id/btn2"
            android:text="Btn"
         app:layout_constraintTop_toBottomOf="@id/btn1"
            app:layout_constraintBottom_toTopOf="@id/btn3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
        <Button
            android:id="@+id/btn3"
            android:text="Btn"
           app:layout_constraintBottom_toBottomOf="parent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>


    </com.sharifiniax.floatingmenu.FloatingMenu>
```

License
-------

    
