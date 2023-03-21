package main

import zio.{ZIO, ZIOAppDefault}
import zio.Console.*

import java.io.IOException
import fp.scala.uno.domain.models.{CarteDeUno, CouleurDeCarte, ValeurNumeriqueDeCarte}
import ValeurNumeriqueDeCarte.*
import CouleurDeCarte.*
import fp.scala.utils.typeclass.eq.Eq.*
import fp.scala.utils.typeclass.show.Show.*

object Main extends ZIOAppDefault:
	override def run: ZIO[Any, IOException, Unit] = myAppLogic

	val myAppLogic: ZIO[Any, IOException, Unit] =
		for {
			_   <- printLine("FP Uno !")
			_   <- printLine(game)
			_ <- printLine(CarteDeUno.CarteNumeric(ZERO, Bleu) === CarteDeUno.CarteNumeric(ZERO, Bleu))
			/*name <- readLine
			_    <- printLine(s"Hello, ${name}, welcome to ZIO!")*/
		} yield ()

	private def game: String = {
		CarteDeUno.CarteNumeric(ZERO, Bleu).show
	}