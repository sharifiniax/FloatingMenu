[![](https://jitpack.io/v/sharifiniax/FloatingMenu.svg)](https://jitpack.io/#sharifiniax/FloatingMenu)

FloatingMenu
===============

This is a simple Menu that you can use it by constraintLayout in android studio. This library is based on answers (https://stackoverflow.com/questions/4139288/android-how-to-handle-right-to-left-swipe-gestures). 


<kbd><img src="https://github.com/sharifiniax/FloatingMenu/blob/master/FloatingMenu.gif" width="100%" height="400px"></kbd>


<h2>Include in your project</h2>

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
MIT License

Copyright (c) 2022 sharifiniax

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
    
