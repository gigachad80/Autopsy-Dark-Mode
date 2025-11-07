

# Autopsy Dark Mode

🚀 Project Name: Autopsy Dark Mode
===============

### Autopsy Dark Mode: A NetBeans module to enable dark theme support in the Autopsy digital forensics platform using FlatLaf for reduced eye strain during long analysis sessions.

![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-purple.svg)
<a href="https://github.com/gigachad80/Autopsy-Dark-Mode/issues"><img src="https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat"></a>


## Table of Contents

* [📌 Overview](#-overview)
* [✨ Features](#-features)
* [📚 Requirements \& Dependencies](#-requirements--dependencies)
* [📥 Installation Guide](#-installation-guide)
* [🚀 Usage](#-usage)
    * [For Users](#for-users)
    * [For Developers](#for-developers)
* [🔧 Technical Details](#-technical-details)
* [🤔 Why This Name?](#-why-this-name)
* [⌚ Development Time](#-development-time) 
* [🙃 Why I Created This](#-why-i-created-this)
* [👏 Credits](#-credits)
* [🤝 Contributing](#-contributing)
* [📞 Contact](#-contact)
* [📄 License](#-license)


### 📌 Overview

**Autopsy Dark Mode** is a lightweight NetBeans module designed to integrate a dark theme into Autopsy, the open-source digital forensics platform built on The Sleuth Kit. It leverages the FlatLaf library to apply a modern, eye-friendly dark UI across Autopsy's interface, making prolonged forensic investigations more comfortable without altering core functionality.

**Key Capabilities:**

* Seamless dark theme activation via Autopsy's module system.
* Automatic UI component restyling for reduced glare and blue light exposure.
* Compatibility with Autopsy 4.22+ for stable performance in case analysis workflows.
* Simple installation as a plugin, with build support for custom modifications.

This module addresses the lack of native dark mode in Autopsy, providing an essential quality-of-life improvement for users in low-light environments or those sensitive to bright screens.

### ✨ Features

### 🌙 Dark Theme Integration

- **FlatLaf-Based Styling**: Applies a professional dark look-and-feel to menus, toolbars, panels, and data views in Autopsy.
- **Eye Strain Reduction**: Dimmed colors and high contrast for text/code during timeline analysis, keyword searches, and file carving tasks.
- **Non-Intrusive**: Preserves all Autopsy features like ingest modules, artifact browsing, and report generation without conflicts.


### ⚙️ Module Compatibility

- **NetBeans Module System**: Built as an NBM (NetBeans Module) for easy loading via Autopsy's plugin manager.

### 🛠️ Developer-Friendly

- **Maven Build System**: Standard Maven project for easy compilation and dependency management.
- **Customizable**: Open-source code allows theme tweaks, such as color adjustments or additional UI components.
- **Tested Workflow**: Verified on Windows/Linux with Autopsy 4.22+, including proxy support for module downloads.


### 📚 Requirements \& Dependencies

* **Autopsy 4.22+**: The module requires Autopsy built on NetBeans platform; download from official site
* **Java 11+**: JDK for building and running; Autopsy bundles its own runtime, but ensure compatibility.
* **Maven 3.6+**: For developers to build from source; install via package manager or Maven website.
* **FlatLaf Library**: Automatically handled as a Maven dependency; no manual setup needed.

No additional Git or external tools required beyond standard Autopsy setup.

### 📥 Installation Guide

### ⚡ Quick Install

**For Users (Plugin Installation):**

1. Download the latest `.nbm` file from the [Releases page](https://github.com/gigachad80/Autopsy-Dark-Mode/releases).
2. Open Autopsy and go to **Tools > Plugins**.
3. Select the **Downloaded** tab, then click **Add Plugins**.
4. Browse to the `.nbm` file and install; restart Autopsy if prompted.

**For Developers (Build from Source):**

```bash
git clone https://github.com/gigachad80/Autopsy-Dark-Mode.git
cd autopsy-dark-mode
mvn clean install
```

The built `.nbm` will be in `target/nbm/autopsy-dark-mode-1.0-SNAPSHOT.nbm`. Install as above.

**Proxy Setup (If Needed):**
In Autopsy: **Tools > Options > General** – enter proxy details for module downloads.

### 🚀 Usage

#### For Users

1. After installation, restart Autopsy.
2. The dark theme activates automatically on launch; if not, go to **Tools > Options > Appearance** and select the FlatLaf dark variant (module registers it).
3. Use Autopsy as usual: Import data sources, run ingest modules (e.g., File Type Identification, Recent Activity), and analyze artifacts.
4. To toggle: **Tools > Plugins > Installed** – disable/enable the module and restart.
5. For manual FlatLaf config (fallback): Edit Autopsy's config file (`autopsy.conf`) to add `-J-Dnetbeans.laf=org.flatlaf.intellijthemes.FlatIntelliJDarkLaf`.[^4]

> [!NOTE]
> ### Known Behavior
> The module may require a full restart for theme changes to apply fully, especially in complex cases with many ingest modules. If UI elements appear inconsistent, clear Autopsy's cache via **Help > About > Reset**.

#### For Developers

1. Clone and build as above to generate the `.nbm`.
2. Customize: Edit `src/main/java/org/sleuthkit/autopsy/darkmode/AutopsyDarkMode.java` for theme logic (e.g., add custom colors).
3. Test: Load the built `.nbm` in a dev Autopsy instance; debug via NetBeans IDE.
4. Package: Run `mvn nbm:nbm` for distribution; upload to Releases.

### 🔧 Technical Details

### Architecture

- **NetBeans Module Framework**: Uses `module.xml` and `layer.xml` for integration into Autopsy's platform.
- **FlatLaf Dependency**: Maven pulls `org.flatlaf:flatlaf:3.2+` for cross-platform dark L\&F.
- **Event-Driven Loading**: Registers on Autopsy startup via `ModuleInstall` for UI restyling.
- **Maven Standard Layout**: `src/main/java` for code, `src/main/resources` for configs; builds to JAR/NBM.


### Performance Characteristics

- **Load Time**: <1 second on startup; no runtime overhead during case analysis.
- **Compatibility**: Tested with Autopsy ingest modules (e.g., Email Parser, Encryption Detection); supports E01/raw images.
- **Build Speed**: ~10-20 seconds with Maven on standard hardware.
- **Size**: Compiled NBM ~100KB, including FlatLaf subsets.


### 🤔 Why This Name?

Descriptive and straightforward: "Autopsy Dark Mode" clearly indicates it's a dark theme enhancement for the Autopsy tool.


### ⌚ Development Time

> [!NOTE]
> Built from scratch in ~5.5 hours despite zero Java experience (as you can see my GitHub bio , I hate this bloated language, so the whole module was vibe‑coded 💀💀).
> Breakdown: ~4 hours coding and testing the FlatLaf integration, 15–20 minutes for setup of first project & installation in this light mode IDE - Apache NetBeans (how much one has to suffer with light mode IDE just to build dark mode), and ~1 hour refining the README/docs. Thanks to Perplexity Pro🥰

### 🙃 Why I Created This

I developed this module purely for personal use because I love dark modes and find Autopsy's default bright interface causes eye strain during forensic analysis . There was no active alternative module available which I found was deprecated ,so I built a simple, reliable solution using FlatLaf to make my workflow comfortable.

### 👏 Credits

- **FlatLaf Team**: For the excellent dark theme library that powers the UI restyling.
- **Sleuth Kit / Autopsy Developers**: For the open-source forensics platform that inspired this module.
- **NetBeans Community**: Documentation and tools for module development.
- **User Feedback**: Early testers who helped validate compatibility with Autopsy 4.22+.


### 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **Fork the repository**
2. **Create a feature branch** (`git checkout -b feature/amazing-feature`)
3. **Commit your changes** (`git commit -m 'Add amazing feature'`)
4. **Push to the branch** (`git push origin feature/amazing-feature`)
5. **Open a Pull Request**

### Development Guidelines

- Follow Java and Maven best practices.
- Test with Autopsy 4.22+; add unit tests for theme logic.
- Update documentation for changes; ensure NBM builds cleanly.
- Maintain backward compatibility with existing Autopsy versions.


### 📞 Contact

- Github Issues
- or mail me @ pookielinuxuser@tutamail.com

### 📄 License

Licensed under the **Apache License 2.0**.
Also see: [LICENSE](LICENSE)

First Published: November 7, 2025
Last Updated: November 7, 2025

---

**Made with frustration 💢🤬 in Java ( bloated lang . sucks )** - Bringing dark comfort 😉😇 to digital forensics.
