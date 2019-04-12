same file

```bash
$ md5sum sub/ValidationEx.scala
07c08ec729c8806cd93d83af1c7a372e  sub/ValidationEx.scala
$ md5sum src/main/scala/example/ValidationEx.scala
07c08ec729c8806cd93d83af1c7a372e  src/main/scala/example/ValidationEx.scala
```

different output

```
$ sbt
sbt:tools> root/compile
[success] Total time: 4 s, completed 2019/04/12 20:25:10
sbt:tools> sub/compile
[error] /path/to/tools/sub/ValidationEx.scala:26:65: could not find implicit value for parameter p: cats.NonEmptyParallel[MyValidator.this.Result,F]
[error]   def validateMany(): Result[Unit] = (validate1(), validate2()).parTupled.map(_ => ())
[error]                                                                 ^
[error] one error found
[error] (sub / Compile / compileIncremental) Compilation failed
[error] Total time: 1 s, completed 2019/04/12 20:25:20
```