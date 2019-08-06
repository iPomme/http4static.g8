package $package$

import cats.effect._
import cats.implicits._
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.server.staticcontent._
import org.http4s.syntax.kleisli._
import scala.sys.env


object Main extends IOApp {

  val service = fileService[IO](FileService.Config("./www/")).orNotFound

  override def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO]
      .bindHttp(env.getOrElse("PORT","8080").toInt,"0.0.0.0")
      .withHttpApp(service)
      .serve
      .compile.drain.as(ExitCode.Success)
}