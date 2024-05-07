import 'package:flutter/material.dart';
import 'package:tp5/application1.dart';
import 'package:tp5/application2.dart';
import 'package:tp5/application3.dart';


void main() {
  runApp(MaClasse3());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: Scaffold(
        body: Center(
          child: Text('Hello World!'),
        ),
      ),
    );
  }
}
