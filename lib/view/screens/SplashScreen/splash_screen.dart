import 'dart:async';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:provider/provider.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:kulturruhr/controllers/Authentication/user_controller.dart';
import 'package:kulturruhr/utils/constants/cutom_logo.dart';
import 'package:kulturruhr/utils/constants/preferences.dart';
import 'package:kulturruhr/utils/routing.dart';

class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    super.initState();
    decideNavigation();
    // _navigateToLogin();
  }

  decideNavigation() async {
    final SharedPreferences prefs = await SharedPreferences.getInstance();
    if (prefs.containsKey(Pref.login_pref)) {
      if (prefs.getBool(Pref.login_pref) ?? false) {
        _navigatetohome(prefs.getString(Pref.user_id)!);
      } else {
        _navigateToLogin();
      }
    } else {
      _navigateToLogin();
    }
  }
  _navToRegister() async {
    await Future.delayed(const Duration(milliseconds: 3000), () {});
    Get.offNamed(AppRoutes.registerScreen);
  }

  _navigateToLogin() async {
    await Future.delayed(const Duration(milliseconds: 3000), () {});
    Get.offNamed(AppRoutes.loginScreen);
  }

  _navigatetohome(String userId) async {
    var userProvider = Provider.of<UserDataController>(context, listen: false);
    await userProvider.setUser(userID: userId);
    "User set to ${userProvider.user!.name}".printInfo();
    "My followings = ${userProvider.user!.following}".printInfo();
    Get.offNamed(AppRoutes.homeNavigationScreen);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xfbE30B5C),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Image.asset(
              CustomLogo.primaryLogo,
              width: 200,
              height: 200,
            ),
            const SizedBox(height: 30),
            const Text(
              'WAVE',
              style: TextStyle(
                color: Colors.white,
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),
          ],
        ),
      ),
    );
  }
}