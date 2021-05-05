# Surf Club Ventures

[https://surfclub.vc](https://surfclub.vc)

## Dev

* Install Java
```
brew tap homebrew/cask-versions
brew update
brew tap caskroom/cask
brew cask install java
```

* Install Clojure `brew install clojure/tools/clojure`
* `git clone git@github.com:zk/surfclub.vc && cd surfclub.vc`
* `bin/charly --dev`

This will boot up various stuff. Visit [http://localhost:5000](http://localhost:5000) when ready.

Everything is hot reloaded, even config.

### Make a change

Open `src/cljs-browser/browser/index.cljs` in your editor. Change something, like the hero heading text around line 199. Changes will be hot loaded into your browser.

Good luck with parens. Maybe download an editor plugin to assist.


## Prod Deploy

Run `bin/build-prod` to deploy your changes to prod

