package $package$

import cats.effect._
import org.http4s._
import org.http4s.implicits._
import org.specs2.matcher.MatchResult
import org.http4s.server.staticcontent._
import org.http4s.dsl.io._
import scala.concurrent.ExecutionContext.Implicits.global
import $package$.Main._

class MainSpec extends org.specs2.mutable.Specification {
  implicit val cs: ContextShift[IO] = IO.contextShift(global)
  implicit val timer: Timer[IO] = IO.timer(global)

  "index.html" >> {
    "return 200" >> {
      uriReturns200()
    }

  }

  "bad.html" >> {
    "return 404" >> {
      uriReturns404()
    }

  }

  private[this] val retIndex: Response[IO] = {
    val getIndex = Request[IO](Method.GET, uri"/index.html")
    service.run(getIndex).unsafeRunSync
  }

  private[this] val retBad: Response[IO] = {
    val getBad = Request[IO](Method.GET, uri"/bad.html")
    service.run(getBad).unsafeRunSync
  }

  private[this] def uriReturns200(): MatchResult[Status] =
    retIndex.status must beEqualTo(Status.Ok)

  private[this] def uriReturns404(): MatchResult[Status] =
    retBad.status must beEqualTo(Status.NotFound)

}