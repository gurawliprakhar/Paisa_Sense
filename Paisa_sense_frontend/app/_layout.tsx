import * as React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import SignupScreen from './(auth)/SignupScreen';
import LoginScreen from './(auth)/LoginScreen';
import ExpensesScreen from './(auth)/ExpensesScreen';

export type RootStackParamList = {
  Signup: undefined;
  Login: undefined;
  Expenses: undefined;
};

const Stack = createNativeStackNavigator<RootStackParamList>();

export default function AppNavigator() {
  return (
    <Stack.Navigator initialRouteName="Login">
      <Stack.Screen name="Signup" component={SignupScreen} />
      <Stack.Screen name="Login" component={LoginScreen} />
      <Stack.Screen name="Expenses" component={ExpensesScreen} />
    </Stack.Navigator>
  );
}
