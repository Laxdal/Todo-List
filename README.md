# Compose Todo - 现代化的待办事项应用

一个使用Jetpack Compose构建的Android待办事项应用，采用Material Design 3设计规范，提供简洁直观的用户界面和丰富的任务管理功能。

## 功能特性

### 1. 任务管理
- ✅ 查看所有任务列表
- ✅ 添加新任务
- ✅ 标记任务完成/未完成
- ✅ 删除任务（长按菜单）
- ✅ 高亮重要任务
- ✅ 置顶关键任务

### 2. 任务状态与排序
- ✅ 已完成任务自动移至底部
- ✅ 已完成任务显示删除线和灰色文字
- ✅ 置顶任务优先显示
- ✅ 按创建时间排序

### 3. 视觉反馈
- ✅ 高亮任务使用不同背景色
- ✅ 任务状态图标（置顶、高亮）
- ✅ 任务完成状态动画
- ✅ 长按菜单交互

### 4. 统计功能
- ✅ 显示总任务数
- ✅ 显示已完成任务数
- ✅ 完成进度展示（x/y格式）

## 技术特性

### 1. 现代化技术栈
- 完全使用Kotlin语言开发
- 基于Jetpack Compose构建UI
- 采用Material Design 3设计系统
- 遵循Android最佳实践

### 2. 架构设计
- 组件化UI设计
- 状态管理（Compose State）
- 响应式UI更新
- 清晰的代码结构

### 3. 用户体验
- 流畅的动画效果
- 直观的操作反馈
- 符合Material You设计语言
- 优化的性能表现

## 项目结构

### 数据层
- 使用data class定义Task模型
- 使用remember和mutableStateOf管理状态

### UI层
主要组件：
- MainActivity: 应用入口和主界面容器
- TodoScreen: 主界面组件
- TaskList: 任务列表组件
- TaskItem: 单个任务项组件
- AddTaskDialog: 添加任务对话框
- TaskStats: 任务统计组件

### 主题
- 使用Material Design 3
- 自定义颜色主题

## 项目结构 