import 'package:flutter/material.dart';

void main() {
  runApp(MaClasse1());
}

class MaClasse1 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text('Première Application Flutter'),
        ), // AppBar
        body: Center(
          child: Text('Hello World'),
        ), // Center
      ), // Scaffold
    ); // MaterialApp
  }
}
