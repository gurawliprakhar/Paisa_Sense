import React, { useState } from 'react';
import { View, TextInput, Button, Text } from 'react-native';

export default function SignupScreen({ navigation }) {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [error, setError] = useState('');

  const handleSignup = () => {
    if (password !== confirmPassword) {
      setError('Passwords do not match');
      return;
    }
    if (!username || !email || !password) {
      setError('Please fill all fields');
      return;
    }
    // Here you can add the signup API call
    console.log('Signup submitted:', { username, email, password });
    setError('');
    navigation.navigate('Login'); // Navigate back to login after signup
  };

  return (
    <View>
      <Text>Signup Screen</Text>
      <TextInput
        placeholder="Username"
        value={username}
        onChangeText={setUsername}
        autoCapitalize="none"
      />
      <TextInput
        placeholder="Email"
        value={email}
        onChangeText={setEmail}
        keyboardType="email-address"
        autoCapitalize="none"
      />
      <TextInput
        placeholder="Password"
        value={password}
        onChangeText={setPassword}
        secureTextEntry={true}
      />
      <TextInput
        placeholder="Confirm Password"
        value={confirmPassword}
        onChangeText={setConfirmPassword}
        secureTextEntry={true}
      />
      <Button title="Sign Up" onPress={handleSignup} />
      {error ? <Text style={{ color: 'red' }}>{error}</Text> : null}
      <Button title="Back to Login" onPress={() => navigation.navigate('Login')} />
    </View>
  );
}
