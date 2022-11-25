package org.acme

import org.apache.flink.table.api.{EnvironmentSettings, TableEnvironment}

import java.time.LocalDate
import org.apache.flink.table.api.Expressions.row
import org.apache.flink.configuration.{Configuration, RestOptions}
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.formats.csv.CsvReaderFormat
import org.apache.flink.connector.file.src.FileSource
import org.apache.flink.core.fs.Path
import org.apache.flink.streaming.api.datastream.DataStream
import org.apache.flink.streaming.api.datastream.DataStreamSource
import org.apache.flink.api.common.eventtime.WatermarkStrategy

@main
def main(): Unit = {

  println("Simple Example to read csv!")

  val conf: Configuration = new Configuration()
  conf.setInteger(RestOptions.PORT, 8081)
  val env: StreamExecutionEnvironment = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(conf)
  env.setParallelism(1)

  val readFormat: CsvReaderFormat[City] = CsvReaderFormat.forPojo(classOf[City])
  val csvSource: FileSource[City] = FileSource.forRecordStreamFormat(readFormat, new Path("test.csv")).build()
  val csvInputStream: DataStream[City] = env.fromSource(csvSource, WatermarkStrategy.noWatermarks(), "csv-source")
  csvInputStream.print("csvInputStream")

  env.execute("flink-csv-reader")

}