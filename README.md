# CyberRural

CyberRural is a 2D game prototype developed in **Java** using **libGDX**.

The game explores a cyberpunk rural setting where there is **no direct combat**.  
Instead, the core challenge comes from an **economic oppression system**: an authoritarian state imposes abusive taxes that increase as the player becomes more profitable.

Resource scarcity, time pressure and economic decisions are the main gameplay drivers.

---

## Current State

This project is currently a **playable prototype**, focused on building a solid technical and architectural foundation.

Implemented features:

- Core game loop (update / render separation)
- Time system with day progression
- Economy system with dynamic tax growth
- Event-based architecture (custom EventBus)
- Basic HUD (money, day progress, day)
- Player entity (placeholder rendering)
- Configuration system (centralized game constants)

---

## Architecture Notes

- The project avoids hard coupling between systems.
- Game logic is event-driven where appropriate.
- Rendering and logic responsibilities will be separate.
- Even as a prototype, code quality and structure are prioritized.

This project is meant to evolve incrementally, without sacrificing maintainability.

---

## Planned Features

- Collision system (AABB-based)
- Interactive world blocks
- Sprite-based rendering
- Expanded event system usage
- Gameplay progression and balancing

---

## Tech Stack

- Java
- libGDX
- Gradle

---

## Status

**Early prototype / active development**

This repository represents an evolving experiment in game architecture and systems design.
