# Compose Todo - A Modern Todo List Application

A Todo List Android application built with Jetpack Compose, following Material Design 3 guidelines, providing a clean, intuitive user interface and rich task management features.

## Features

### 1. Task Management
- ✅ View all tasks
- ✅ Add new tasks
- ✅ Mark tasks as complete/incomplete
- ✅ Delete tasks (long-press menu)
- ✅ Highlight important tasks
- ✅ Pin critical tasks

### 2. Task Status & Sorting
- ✅ Completed tasks automatically move to bottom
- ✅ Completed tasks show strikethrough and gray text
- ✅ Pinned tasks display at top
- ✅ Sort by creation time

### 3. Visual Feedback
- ✅ Different background color for highlighted tasks
- ✅ Task status icons (pinned, highlighted)
- ✅ Task completion animation
- ✅ Long-press menu interaction

### 4. Statistics
- ✅ Display total task count
- ✅ Show completed task count
- ✅ Completion progress (x/y format)

## Technical Features

### 1. Modern Tech Stack
- Fully developed in Kotlin
- UI built with Jetpack Compose
- Material Design 3 system
- Following Android best practices

### 2. Architecture Design
- Componentized UI design
- State management (Compose State)
- Reactive UI updates
- Clear code structure

### 3. User Experience
- Smooth animations
- Intuitive operation feedback
- Material You design language
- Optimized performance

## Project Structure

### Data Layer
- Task model defined using data class
- State management using remember and mutableStateOf

### UI Layer
Main components:
- MainActivity: App entry and main container
- TodoScreen: Main screen component
- TaskList: Task list component
- TaskItem: Single task item component
- AddTaskDialog: Add task dialog
- TaskStats: Task statistics component

### Theme
- Using Material Design 3
- Custom color theme

## Development Environment

- Android Studio Hedgehog | 2023.1.1
- Kotlin 1.9.0
- Gradle 8.2
- Compose BOM 2024.02.00
- minSdk 24
- targetSdk 34

## License
MIT License
Copyright (c) 2024 Lawrence Ge

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 