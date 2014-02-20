val copyAssets = TaskKey[Seq[(File,File)]]("copy-assets", "Copies assets to the output directory.")

def copyAssetsTask = (classDirectory in Compile, resourceManaged in WebKeys.Assets, streams) map {
  (target, dirs, s) => {
    val cacheFile = s.cacheDirectory / "copy-resources"
    val mappings = (dirs.***.get --- dirs) pair (rebase(dirs, target) | flat(target))
    Sync(cacheFile)(mappings)
    mappings
  }
}

copyAssets <<= copyAssetsTask

copyResources in Compile <<= copyAssets dependsOn (copyResources in Compile)

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-directives" % "0.7.1",
  "net.databinder" %% "unfiltered-filter" % "0.7.1",
  "net.databinder" %% "unfiltered-jetty" % "0.7.1"
)

webSettings

jsEngineSettings

lessSettings
