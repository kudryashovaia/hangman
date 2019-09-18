import com.typesafe.config.{Config, ConfigFactory}
import net.ceedubs.ficus.Ficus._

package object params {
  val applicationConf: Config = ConfigFactory.load()
  val library= applicationConf.as[Seq[String]]("resources.library")
}
