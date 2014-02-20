import unfiltered.request._
import unfiltered.response._
import unfiltered.jetty._
import unfiltered.filter._
import unfiltered.directives._, Directives._

object Server extends App {
  Http(8080).resources(getClass.getResource("/")).filter(Planify(Directive.Intent {
    case Path("/") =>
      for {
        _ <- GET
      } yield Html(
        <html>
          <head>
            <link rel="stylesheet" type="text/css" href="/css/app.css" />
          </head>
          <body>
            <h1>Title</h1>
            <div id="container">
              <p><a href="https://github.com/unfiltered/unfiltered">unfiltered/unfiltered</a></p>
            </div>
          </body>
        </html>
      )
  })).run()
}
