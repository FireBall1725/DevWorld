# Devworld

## Table of Contents

* [About](#about)
* [Project Links](#projectlinks)
* [License](#license)
* [Downloads](#downloads)
* [Installation](#installation)
* [Issues](#issues)
* [Credits](#credits)

## About

This mod adds on the game's home screen a one click button to create a new development world that has some handy pre-sets.  By default this will create a world that is flat, cheats enabled, creative mode, set the time to noon and change a few game rules to disable mob spawning and freeze the time.

It is planned for a future update to have a configuration to be able to change these options

![](http://media-elerium.cursecdn.com/attachments/34/723/screenshot-2016-04-08-18.png)

## Project Links

* [GitHub](https://github.com/FireBall1725/DevWorld)
* [CurseForge](http://minecraft.curseforge.com/projects/devworld)
* [Bug Tracker](https://github.com/FireBall1725/DevWorld/issues)

## License

This mod is all rights reserved, Copyright 2016 FireBall1725

## Downloads

This mod's official download can be found on [CurseForge](http://minecraft.curseforge.com/projects/devworld/files), but it is recommended to download it via your gradle script right into your development environment.

## Installation

### Not using Gradle Script
1. Download the mod from [CurseForge](http://minecraft.curseforge.com/projects/devworld/files)
2. Place mod in your dev environment mods folder

### Using your Gradle Script
Add my Maven Server to your dependencies or add the repositories section to your gradle script

```groovy
repositories {
    mavenLocal()
    mavenCentral()

    maven {
        name "FireBall API Depot"
        url "http://dl.tsr.me/artifactory/libs-release/"
    }
}
```

Add the mods configuration to your configuration section, or add it if it doesn't already exist

```groovy
configurations {
    mods
}

task installMods(type: Copy, dependsOn: "deinstallMods") {
    from { configurations.mods }
    include "**/*.jar"
    into file(minecraft.runDir + "/mods")
}

task deinstallMods(type: Delete) {
    delete fileTree(dir: minecraft.runDir + "/mods", include: "*.jar")
}

tasks.setupDecompWorkspace.dependsOn installMods
tasks.setupDevWorkspace.dependsOn installMods
```

Add DevWorld as a dependency to your dependencies section

```groovy
dependencies {
    mods "com.fireball1725.devworld:devworld:[Minecraft Version]-b[Build Number]-universal"
}
```

Make sure to fill in the correct Minecraft Version and Build Number

## Issues
Have a suggestion, found a bug?  Create an issue now!

1. Make sure your issue has not already been answered or fixed and you are using the latest version. Also think about whether your issue is a valid one before submitting it.
2. Go to [the issues page](https://github.com/FireBall1725/DevWorld/issues) and click [new issue](https://github.com/FireBall1725/DevWorld/issues/new)
3. Enter your a title of your issue (something that summarizes your issue), and then create a detailed description of the issue.
    * Do not tag it with something like `[Feature]` or `[Bug]`. When it is applicable, we will take care of it.
    * The following details are required. Not including them can cause the issue to be closed.
        * Forge version
        * DevWorld version
        * Crash log, when reporting a crash (Please make sure to use [pastebin](http://pastebin.com/))
            * Do not post an excerpt of what you consider important, instead:
            * Post the full log
        * Other mods and their version, when reporting an issue between AE and another mod
            * Also consider updating these before submitting a new issue, it might be already fixed
        * A detailed description of the bug or feature
    * To further help in resolving your issues please try to include the follow if applicable:
        * What was expected?
        * How to reproduce the problem?
            * This is usually a great detail and allows us to fix it way faster
        * Server or Single Player?
        * Screen shots or Pictures of the problem
        * Mod Pack using and version?
            * Keep in mind that some mods might use an outdated version of DevWorld
            * If so you should report it to your modpack
5. Click `Submit New Issue`, and wait for feedback!

## Credits
Thanks to the following people:

* [FireBall1725](https://twitter.com/FireBall1725) for DevWorld
* all the [contributors](https://github.com/FireBall1725/DevWorld/graphs/contributors)