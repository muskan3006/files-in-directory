package com.knoldus

import java.io.File

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object FilesInDirectory extends App {


  def directoryPrinter(path: String): Unit = {
    val file: File = new File(path)
    val fileList = file.listFiles
    for (files <- fileList) {
      if (files.isFile) print(files.getPath + " | ") else Future {
        directoryPrinter(files.getPath)
      }
    }
  }

  directoryPrinter("/home/knoldus/workspace/files-in-directory")
}

