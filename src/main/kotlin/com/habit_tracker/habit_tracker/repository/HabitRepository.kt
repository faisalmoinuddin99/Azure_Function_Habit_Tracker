package com.habit_tracker.habit_tracker.repository

import com.habit_tracker.habit_tracker.model.Habit
import org.springframework.data.jpa.repository.JpaRepository

interface HabitRepository : JpaRepository<Habit, Long> {
}