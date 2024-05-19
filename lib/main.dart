import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:get/route_manager.dart';
import 'package:kulturruhr/controllers/Authentication/auth_screen_controller.dart';
import 'package:kulturruhr/controllers/Authentication/user_controller.dart';
import 'package:kulturruhr/controllers/HomeNavController/home_nav_controller.dart';
import 'package:kulturruhr/controllers/PostController/create_post_controller.dart';
import 'package:kulturruhr/utils/routing.dart';
import 'package:provider/provider.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(const Wave());
}

class Wave extends StatelessWidget {
  const Wave({super.key});

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(
          create: (context) => AuthScreenController(),
        ),
        ChangeNotifierProvider(
          create: (context) => UserDataController(),
        ),
        ChangeNotifierProvider(
          create: (context) => HomeNavController(),
        ),
        ChangeNotifierProvider(
          create: (context) => CreatePostController(),
        ),
      ],
      child: GetMaterialApp(
        getPages: AppRoutes.routes,
        initialRoute: AppRoutes.splashScreen,
      ),
    );
  }
}
