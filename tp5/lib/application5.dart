
import 'package:flutter/material.dart';
void main() => runApp (MyHomePage());
class MyHomePage extends StatelessWidget{
final List Liste = List.generate (1000, (index) {
return {
};
});
"id": index,
"title": "This is the title $index",
"subtitle": "This is the subtitle $index"
@override
Widget build(BuildContext context) {
return MaterialApp(
home: Scaffold(
appBar: AppBar (
title: Text('App'),
), // AppBar

}
body: ListView.builder(
itemCount: Liste.length,
itemBuilder: (context, index) =>Card(
elevation: 6,
margin: EdgeInsets.all(10), child: ListTile(
-leading: CircleAvatar (
child: Text(Liste[index]["id"].toString()), backgroundColor: Colors.purple,
), // CircleAvatar
title: Text(Liste[index]["title"]), subtitle:
Text(Liste[index]["subtitle"]),
trailing: Icon(Icons.add_link),
), // ListTile
), // Card
) // ListView.builder
) // Scaffold
); // MaterialApp