
class MaClasse3 extends StatelessWidget{ @override
Widget build(BuildContext context) { return MaterialApp(
debugShowChecked ModeBanner: false,
home: Scaffold(
appBar: AppBar(
title: Text('Troisième Application Flutter'),
), // AppBar
body: Center(
child: Column(
mainAxisAlignment: MainAxis Alignment.spaceEvenly, children: [
Container(
child: Image.asset('images/6.jpg',fit: BoxFit.fill),
width: 350, ), // Container Text('Hello Word'),
) // Column
) // Center
), // Scaffold // MaterialApp