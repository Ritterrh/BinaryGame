import 'package:flutter/material.dart';
import 'package:kulturruhr/utils/constants/custom_fonts.dart';

class MoreOptionForOtherProfile extends StatelessWidget {
  const MoreOptionForOtherProfile({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
        child: Wrap(
      children: [
        ListTile(
          leading: const Icon(Icons.logout),
          title: Text('Logout',
              style: TextStyle(fontFamily: CustomFont.poppins, fontSize: 14)),
          onTap: () async {
            // Close the bottom sheet
          },
        ),
      ],
    ));
  }
}
