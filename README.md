# http4static giter8 template

Forked from [http4s g8 template](http4s/http4s.g8)

Serve static web site under ./www folder

Create the project
1. [Install sbt](http://www.scala-sbt.org/1.0/docs/Setup.html)
2. `sbt new iPomme/http4static.g8`
3. `cd http4static`
4. copy static HTML files under `./www`

Test locally

5. `sbt run`
6. open http://localhost:8080/index.html in a browser


deploy on Heroku
1. `heroku create myStaticSite`
2. `git remote add heroku https://git.heroku.com/myStaticSite.git`
3. `git commit -am "message"`
4. `git push`
5. open http://myStaticSite.herokuapp.com/index.html in a browser

[based on http4s](http://http4s.org/)


Note:

We have enabled [sbt-partial-unification](https://github.com/fiadliel/sbt-partial-unification) 
necessary for utilizing all features of Http4s and Cats.
As well as [sbt-revolver](https://github.com/spray/sbt-revolver) for easier project reloading.

We have commented out the [sbt-tpolecat](https://github.com/DavidGregory084/sbt-tpolecat) plugin in the generated `project/plugins.sbt`.
We highly recommend it for projects, but it may not be a good baseline for new users.
