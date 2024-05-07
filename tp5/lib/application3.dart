import 'package:flutter/material.dart';
void main() {
  runApp(MaClasse3());
}
class MaClasse3 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text('Troisième Application Flutter'),
        ), // AppBar
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Image.asset('images/6.jpg'),
              Text('Hello World'), // Text
            ], // children
          ), // Column
        ), // Center
      ), // Scaffold
    ); // MaterialApp
  }
}
