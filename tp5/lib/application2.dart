import 'package:flutter/material.dart';
void main() {
  runApp(MaClasse2());
}
class MaClasse2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text('Deuxième Application Flutter'),
        ), // AppBar
        body: Center(
          child: Container(
            padding: EdgeInsets.all(20),
            decoration: BoxDecoration(
              border: Border.all(
                color: Colors.black,
                width: 8,
              ), // Border.all
              borderRadius: BorderRadius.circular(12),
            ), // BoxDecoration
            child: Text(
              'Hello World',
              style: TextStyle(
                color: Colors.deepPurpleAccent,
              ), // TextStyle
            ), // Text
          ), // Container
        ), // Center
      ), // Scaffold
    ); // MaterialApp
  }
}
