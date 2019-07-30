<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>test01</title>
<style>

#hd li a {
	color: white;
	text-decoration: none;
}

li a:hover {
	text-decoration: underline;
}

ul {
	list-style: none;
	text-align: center;
}

nav li {
	display: inline-block;
	padding: 10px;
	color: white;
}

#hd {
	width: 100%;
	height: 3em;
	background-color: black;
}

#l {
	text-align: center;
	width: 20%;
	float: left;
	width: 20%;
}

section {
	width: 60%;
	float: left;
	background-color: yellow;
}

#r {
	text-align: center;
	width: 20%;
	float: left;
	width: 20%;
}

footer {
	clear: both;
	text-align: center;
}
</style>
</head>
<body>
	<div id="">
		<header>
			<hgroup>
				<h1>Page Title</h1>
				<h2>Page SubTitle</h2>
			</hgroup>
		</header>
		<nav id="hd">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">Tutorials</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</nav>
		<aside id="l">
			<h3>Top Links</h3>
			<nav>
				<ul>
					<li><a href="#">Link 1</a></li>
					<br>
					<li><a href="#">Link 2</a></li>
					<br>
					<li><a href="#">Link 3</a></li>
					<br>
					<li><a href="#">Link 4</a></li>
					<br>
					<li><a href="#">Link 5</a></li>
				</ul>
			</nav>
		</aside>
		<section>
			<article>
				<h2>Article Title</h2>
				<div>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
					sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
					Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
					reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
					pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
					culpa qui officia deserunt mollit anim id est laborum.</div>
			</article>
			<article>
				<h2>Article Title</h2>
				<div>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
					sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
					Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
					reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
					pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
					culpa qui officia deserunt mollit anim id est laborum.</div>
			</article>
		</section>
		<aside id="r">
			<h3>Top Links</h3>
			<nav>
				<ul>
					<li><a href="#">Link 1</a></li>
					<br>
					<li><a href="#">Link 2</a></li>
					<br>
					<li><a href="#">Link 3</a></li>
					<br>
					<li><a href="#">Link 4</a></li>
					<br>
					<li><a href="#">Link 5</a></li>
				</ul>
			</nav>
		</aside>
	<jsp:include page="./footer.jsp"></jsp:include>
	</div>
</body>
</html>