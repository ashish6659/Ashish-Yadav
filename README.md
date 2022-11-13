<h3 align="center"> Introducing to Login Test Android App </h3>

In this App Login using Email OTP is implemented, Where user has to enter their Valid Email and an OTP will sent Using SMTP( Simmple Mail Transfer Protocol) and mail contain 6-digit OTP Code. The user have to enter the Code Under 30 sec because there is a time limit After 30 sec code will Expire.
After Successful Login, The User Email will be Displayed on the Next Screen along with Logout Button.
Once Logout Button pressed User will be Redirected to the Login Screen.

### <p align="center"> Enjoy the SnapShot of the App. </p>

<p align="center"> 
<img src="https://firebasestorage.googleapis.com/v0/b/scanner-dashboard-59be6.appspot.com/o/Screenshot_2022-11-13-14-19-31-39_db934eeeaadf17deb508dd83de141b7b.jpg?alt=media&token=cf016f61-8094-4a1f-9f08-9c3978d90f24" width="250px" alt="1st mobile image" />
<img src="https://firebasestorage.googleapis.com/v0/b/scanner-dashboard-59be6.appspot.com/o/Screenshot_2022-11-13-14-19-39-41_db934eeeaadf17deb508dd83de141b7b.jpg?alt=media&token=14205fbf-8c63-44b9-829f-413acdf54194" width="250px" alt="2nd mobile image" />
<img src="https://firebasestorage.googleapis.com/v0/b/scanner-dashboard-59be6.appspot.com/o/Screenshot_2022-11-13-14-19-52-77_db934eeeaadf17deb508dd83de141b7b.jpg?alt=media&token=0d019052-2a85-4849-86ad-f5c122361f18" width="250px" alt="3rd mobile image" />
<img src="https://firebasestorage.googleapis.com/v0/b/scanner-dashboard-59be6.appspot.com/o/Screenshot_2022-11-13-14-21-05-96_db934eeeaadf17deb508dd83de141b7b.jpg?alt=media&token=5e81f3b8-8457-4e45-ae5d-9c3a2496425c" width="250px" alt="4th mobile image" />
</p>

### <p align="center"> About the App </p>
#### <p align="center"> This App is Developed in Android Studio using Java to implement the Login using Email OTP. There is a Splash Screen which is the Welcome Screen of the App after that user will be redirected towards Login Page where Email Verification is done. </p>

<br />

### <p align="center"> ** Important Links **</p>
<h3 align="center"> Download and Install the App to Check the Working of the Assignment.</h3>
#### <p align="center"> [ Download the App.](https://firebasestorage.googleapis.com/v0/b/scanner-dashboard-59be6.appspot.com/o/Login%20Test%20App.apk?alt=media&token=fd1cfde7-80db-4279-a802-9c53c86ccbb6/) </p>
<h3 align="center"> Below is the Screen Recording of the App. Check Working in the Video</h3>
#### <p align="center"> [ Checkout The Project Video](https://firebasestorage.googleapis.com/v0/b/scanner-dashboard-59be6.appspot.com/o/Record_2022-11-13-14-23-23.mp4?alt=media&token=142e9eee-d46a-4bb9-8591-082265622408) </p>


<br/>

### <p align="center"> SetUp Instructions </p>

To run this project in Android Studio, Using Git [Copy this Link !!](https://github.com/ashish6659/Ashish-Yadav.git).

or Download .zip file, Extract and import into Android Studio. [Download Here !!](https://github.com/ashish6659/Ashish-Yadav/archive/refs/heads/master.zip).

After importing the Project, In [MainActivity.java](https://github.com/ashish6659/Ashish-Yadav/blob/master/app/src/main/java/com/amdevops/jaxl/auth/MainActivity.java)

##### Email Address & Password is used for Authentication.
``` 
final String username="ashish_mc21014@srmcem.ac.in";

```
and Passowrd is Stored in the Values Directory [String.xml](https://github.com/ashish6659/Ashish-Yadav/blob/master/app/src/main/res/values/strings.xml).

##### Email Address & Password is used for Authentication.
``` 
<string name="ep">Encrypted password</string>

```

Which is Retrieved using following line of Codes

``` 
String l1=new String(Base64.decode(getString(R.string.ep),Base64.DEFAULT));
String pass= new String(Base64.decode(l1, Base64.DEFAULT));

```

### <p align="center"> Libraries Used </p>
##### Add the dependency for mailing.
```build
dependencies {
    implementation 'com.sun.mail:android-mail:1.6.0'
}
```
##### Add the dependency for authenticating mail credentials
```build
dependencies {
    implementation 'com.sun.mail:android-activation:1.6.0'
}
```
##### Add the dependency of PinView for OTP layout
```build
dependencies {
    implementation 'io.github.chaosleung:pinview:1.4.4'
}
```
