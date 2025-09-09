import React, { useState } from 'react';
import { View, Text, TextInput, Button, Alert, StyleSheet } from 'react-native';
import axios from 'axios';
import { useRouter } from 'expo-router';
import { BASE_URL } from '../../../constants/api';


export default function SignupScreen() {
  const router = useRouter();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loading, setLoading] = useState(false);

  const handleSignup = async () => {
    if (!email || !password) {
      Alert.alert('Error', 'Email aur password daalein');
      return;
    }

    setLoading(true);
    try {
      // Backend request using BASE_URL
      await axios.post(`${BASE_URL}:8080/auth/signup`, { email, password });
      Alert.alert('Success', 'Signup successful! Ab login karein');

      // Navigate to Login screen
      router.push('/(tabs)/login');
    } catch (error) {
      console.error(error);
      Alert.alert('Signup Failed', 'Kuch galat ho gaya');
    } finally {
      setLoading(false);
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Signup</Text>
      <TextInput
        style={styles.input}
        placeholder="Email"
        value={email}
        onChangeText={setEmail}
        keyboardType="email-address"
        autoCapitalize="none"
      />
      <TextInput
        style={styles.input}
        placeholder="Password"
        value={password}
        onChangeText={setPassword}
        secureTextEntry
      />
      <Button title={loading ? 'Signing up...' : 'Signup'} onPress={handleSignup} disabled={loading} />
      <Button title="Already have account? Login" onPress={() => router.push('/(tabs)/login')} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, justifyContent: 'center', padding: 20 },
  title: { fontSize: 28, fontWeight: 'bold', marginBottom: 24, textAlign: 'center' },
  input: { borderWidth: 1, borderColor: '#ccc', padding: 12, borderRadius: 8, marginBottom: 16 },
});
